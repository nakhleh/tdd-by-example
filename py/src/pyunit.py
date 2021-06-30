
class TestCase:
    def __init__(self, name):
        self.name = name
    
    def setUp(self):
        pass
    def tearDown(self):
        pass
    def run(self):
        result = TestResult()
        result.testStarted()
        try:
            self.setUp()
            method = getattr(self, self.name)
            method()
            self.tearDown()
        except Exception:
            result.testFailed()
        return result

class TestResult:
    def __init__(self):
        self.runCount = 0
        self.errorCount = 0

    def testStarted(self):
        self.runCount += 1
    
    def testFailed(self):
        self.errorCount += 1

    def summary(self):
        return "%d run, %d failed" % (self.runCount, self.errorCount)

class WasRun(TestCase):
    def __init__(self, name):
        super().__init__(name)

    def setUp(self):
        self.log = "setUp "
    def testMethod(self):
        self.log += "testMethod "
    def testBrokenMethod(self):
        raise Exception
    def tearDown(self):
        self.log += "tearDown"

class InvalidSetup(TestCase):
    def __init__(self, name):
        super().__init__(name)

    def setUp(self):
        raise Exception
    def testMethod(self):
        self.log += "testMethod "
    def tearDown(self):
        self.log += "tearDown"

def testStringsAreEqual(expected, actual):
    if expected == actual:
        print("Test passed")
    else:
        print(f"FAILED: {expected} != {actual}")

class TestCaseTest(TestCase):
    def testTemplateMethod(self):
        test = WasRun("testMethod")
        test.run()
        testStringsAreEqual("setUp testMethod tearDown", test.log) 
        assert "setUp testMethod tearDown" == test.log

    def testResult(self):
        test = WasRun("testMethod")
        result = test.run()
        testStringsAreEqual("1 run, 0 failed", result.summary()) 
        assert "1 run, 0 failed" == result.summary() 

    def testResultSetupFailed(self):
        test = InvalidSetup("testMethod")
        result = test.run()
        testStringsAreEqual("1 run, 1 failed", result.summary()) 
        assert "1 run, 1 failed" == result.summary() 

    def testResultFailed(self):
        test = WasRun("testBrokenMethod")
        result = test.run()
        testStringsAreEqual("1 run, 1 failed", result.summary()) 
        assert "1 run, 1 failed" == result.summary() 
    
    def testFailedResultFormatting(self):
        result = TestResult()
        result.testStarted()
        result.testFailed()
        testStringsAreEqual("1 run, 1 failed", result.summary()) 
        assert "1 run, 1 failed" == result.summary() 


TestCaseTest("testTemplateMethod").run()
TestCaseTest("testResult").run()
TestCaseTest("testResultSetupFailed").run()
TestCaseTest("testResultFailed").run()
TestCaseTest("testFailedResultFormatting").run()




