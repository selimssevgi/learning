# intro to spring batch

- release in 2008

- JobRepository: persist meta-data about batch jobs

- JobExplorer: retrieves meta-data from the JobRepository

- JobLauncher: runs jobs with given parameters


## terms

- job
- job instance
- job execution
- job parameters
- step
- step execution

## job configuration

- JobBuilderFactory

- SimpleJobBuilder: provides a DSL for defining how the job is constructed

## step configuration

- StepBuilderFactory

- Tasklet: defines what task the step will actually perform
