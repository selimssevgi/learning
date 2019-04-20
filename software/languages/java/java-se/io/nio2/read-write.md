# Reading and Writing Data

- BufferedReader br = Files.newBufferedReader(Path, StandardCharsets.UTF_8))
- BufferedWriter bw = Files.newBufferedWriter(source, UTF_8, StandardOpenOption.WRITE)
- Files.newInputStream(Path, OpenOption...)
- Files.newOutputStream(Path, OpenOption...)

- Path logFile       = Paths.get("/tmp/app.log");
- List<String> lines = Files.readAllLines(logFile, StandardCharsets.UTF_8);
- byte[] bytes       = Files.readAllBytes(logFile);
