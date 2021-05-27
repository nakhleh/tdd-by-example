# Go project

Targets Go 1.16


To run tests, you SHOULD be able to do:

```bash
go test -v ./...
```

But it doesn't seem to work, regardless of what the docs and internet say. Instead, you
apparently have to cd to pkg/currency, then you can run:

```bash
go test -v
```



To build the program:

```bash
go build ./...
```

It puts the output in the current working directory.