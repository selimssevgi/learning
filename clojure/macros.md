# Macros

- Are one of the key concepts of Lisp-like languages
- There should be a little distinction between built-in construct and ordinary code as possible
- Allow to create forms that behave like built-in syntax


```clojure
(def hello (fn [] "Hello World"))

(defn hello [] "Hello World")
```
