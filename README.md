# cljs-react-bootstrap

> A single-page application with [ClojureScript][cljs-url], [React][react-url] and [Bootstrap][bootstrap-url]

This is an example of a [Bootstrap][bootstrap-url]-powered single-page application in [ClojureScript][cljs-url] using [reagent][reagent-url], [re-frame][reframe-url] and [cljsjs][cljsjs-url]-packaged [React-Bootstrap][react-bootstrap-url], kickstarted with the [Leiningen][lein-url] [re-frame template][re-frame-template-url].

## Developing

### Run application:

```sh
$ lein clean
$ lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Building

```sh
$ lein clean
$ lein cljsbuild once min
```

[cljs-url]: https://github.com/clojure/clojurescript
[react-url]: https://facebook.github.io/react/
[bootstrap-url]: https://getbootstrap.com/
[reagent-url]: https://reagent-project.github.io/
[reframe-url]: https://github.com/Day8/re-frame
[cljsjs-url]: https://github.com/cljsjs/packages
[react-bootstrap-url]: https://react-bootstrap.github.io
[lein-url]: https://leiningen.org/
[re-frame-template-url]: https://github.com/Day8/re-frame-template