# clojure_course_task02

Необходимо написать программу, которая ищет указанные файлы в указанном каталоге.

## Usage

    $ lein uberjar
    $ ./run.sh "^core.+" "./"

Здесь первый параметр -- regexp, который задает имя искомого файла. Второй параметр -- путь, по которому необходимо искать файлы.

Организовать поиск во вложенных каталогах при помощи параллельных потоков.


## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.
