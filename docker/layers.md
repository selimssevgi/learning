# Layers

- Images maintain parent/child relationships

- The files available to a container are the union of all of the layers in the
  lineage of the image the container was created from.

- Structuring images with layers enables layer reuse and saves bandwidth during
  distribution and storage space on your computer.
