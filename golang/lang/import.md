# import

```go
import "fmt" // for single import
```

```go
import (     // multi-import
   "fmt"
   "os"
   "path/filepath"
)
```

- When a package is imported, no matter whether its top-level or logically
  inside another package (path/filepath), we always to refer to it using only
  the last component of its name(filepath)

## Types of Imports

- source code
- local packages
- remote packages
