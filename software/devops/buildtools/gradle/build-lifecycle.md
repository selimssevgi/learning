# gradle's build lifecycle phases

- whenever you execute a gradle build, 3 distinct lifecycle phases are run:

1. initialization
2. configuration
3. execution

- gradle's incremental build feature is tightly integrated in the lifecycle

## initialization

- gradle creates a Project instance

- settings.gradle is evaluated and executed

- gradle determines the execution of projects(in multiproject dependencies)

## configuration

- gradle constructs a model representation of the tasks that will take part in the build

- the incremental build feature determines if any of the tasks in the model are required to be run

- this phase is perfect for setting up the configuration that's required for
  your project or specific tasks

*important:* keep in mind that any configuration code is executed with every
build of your project -- even if you just execute "gradle tasks"

## execution

- tasks are executed in correct order


**important:** gradle makes a clear distinction between task actions and task
configurations. Tasks actions, defined through the closures doFirst and doLast,
and run during the execution phase. Any other code defined outside of a task
action is considered a configuration and therefore executed beforehand during
the configuration phase.
