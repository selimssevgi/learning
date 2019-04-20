# Continuous Integration

- Developers make changes to code, then all the code changes are merged.
- Merging may involves the integration of lots of conflicting changes.
- Often, after such merging some parts of software might stop working, bugs.
- Nothing goes as planned, unexpected outcome brings lots of problems.

- CI is an XP concept.
- It was introduced to overcome integration problems.

- Developers commit the code periodically.
- Every commit is built.
- Automated tests verify the system integrity.
- It helps in the incremental development and periodic delivery of the working
  software.

## Benefit of CI

- Make sure additions not breaking anything.
- Run tests continuously
- Be warned if they fail

- CI requires a listener tool to keep an eye on the vcs for changes.
- In case of any change, this tool automatically compiles and tests the application.
- In case of fail, CI tool notifies responsible team.

- CI is a concept.
- Tools such as Sonar or FindBugs can be added to build process.
- Good quality code gives us confidence, that a team is following the right path.
- Technical debts can be identified very quickly, and the team can start reducing the debts.

- CI tools enforce code quality, predictability, and provide quick feedback.
- CI helps to increase the confidence in the build.

### CI Tools

- Go,
- Bamboo
- TeamCity
- CruiseControl(widely used)
- Jenkins(widely used)

## Jenkins

- Jenkins needs build scripts to execute test, compile source, deploy deliverables.
- Jenkins supports different build tools to execute the commands.(Gradle, Maven)
