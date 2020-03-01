# lazy loading

- if using feature modules to organize code, then can use `lazy/asynch loading`

- when we want to lazy load, we don't want to import the module into AppModule directly

```shell
{ path: 'blogs', loadChildren: 'app/blogs/blogs.module#BlogsModule' },
```
