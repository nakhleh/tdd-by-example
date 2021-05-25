import unittest

from ..dollar import Dollar

class TestDollar(unittest.TestCase):
    def test_multiplication(self):
        """Test a simple multiplication"""
        d = Dollar(5)
        d.times(2)
        self.assertEqual(d.amount, 10)

