# Volume Container Pattern

- A container that does a little more than provide a handle to volumes

- This is useful if you come across a case for sharing a set of volumes with
  many containers, or if you can categorize a set of volumes that fit a common use case

- A volume container doesn't need to be running because stopped contaieners
  maintain their volume references

- Volume containers are important for keeping a handle on data even in cases
  where a single container should have exclusive access to some data. These
  handles make it possible to easily back up, restore, and migrate data

- Updating database software with a volume container
  - shut down of database software container
  - run the new version
  - db software should be able to read the earlier format, and from same location

*NOTE*
Using a container name prefix such as vc\_ would be great hint for humans or
scripts not to use the -v option when deleting a container

- There should be convention/contract to read/write to/from same mounted location
  - volume container uses /logs
  - consumer container expects to read from /var/logs
  - fail!

- The volume container pattern is more about simplicity and convention than
  anything else. It's a fundamental tool for working with data in Docker and can
  be extended in a few interesting ways
