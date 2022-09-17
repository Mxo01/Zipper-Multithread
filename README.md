# File zipper multi-thread

The main goal is to create the relative ".zip" for each existing 
file within each directory passed on the command line. I used the
GZIP utility provided by Java to zip each file and the program 
is also able to recursively enter subdirectories and zip the 
contained files using a thread pool.


## Documentation

In this project you will find some API or utility like [GZIPInputStream](https://docs.oracle.com/javase/7/docs/api/java/util/zip/GZIPInputStream.html)
or [GZIPOutputStream](https://docs.oracle.com/javase/7/docs/api/java/util/zip/GZIPOutputStream.html), which allow the compression of files to make them in zip format.

You are probably looking for some utilities to read or write to file/stream and the package that makes it easier is definitely
 [File](https://docs.oracle.com/javase/7/docs/api/java/io/File.html). For multi-threading see [Thread](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html) but in this project i've used a cached thread pool, see [ExecturService](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ExecutorService.html) and [Executors](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Executors.html).


## Installation (Windows)

First of all you need to install jdk from [Downloads](https://www.oracle.com/java/technologies/downloads/).

So check everything is ok:
```bash
  javac --version
  java --version
```
If you're using Visual Studio Code check this [Extension](https://code.visualstudio.com/docs/java/extensions).

On Linux it is much simpler and you just have to write a few lines of code on the terminal and you are done.
    
## Authors

For doubts or concerns mariodimodica.01@gmail.com. 
- [@mxo01](https://github.com/Mxo01)

