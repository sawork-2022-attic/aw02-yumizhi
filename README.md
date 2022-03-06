# POS in Shell

The demo shows a simple POS system with command line interface. 

To run

```shell
mvn clean spring-boot:run
```

Currently, it implements three commands which you can see using the `help` command.

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.5.7)
 
shell:>help
AVAILABLE COMMANDS

Built-In Commands
        clear: Clear the shell screen.
        exit, quit: Exit the shell.
        help: Display help about available commands.
        history: Display or save the history of previously run commands
        script: Read and execute commands from a file.
        stacktrace: Display the full stacktrace of the last error.

Pos Command
        a: Add a Product to Cart
        n: New Cart
        p: List Products
```

Everytime a customer come to make a purchase, use `n` to create a new cart and then use `a ${productid} ${amount}` to add a product to the cart.

Please make the POS system robust and fully functional by implementing more commands, for instance, print/empty/modify cart.

Implementing a PosDB with real database is very much welcome. 

Please use asciinema (https://asciinema.org) to record a demo and submit the url in QQ group. 

And please elaborate your understanding in layered systems via this homework in your README.md.



# Understanding

- Homework中是一个Three-Layer的架构

  - ```mermaid
    graph TB
    	A[CLI] --> B[BIZ] --> C[DB] -->B --> A
    ```

- 分层架构使用层来分隔不同的功能模块。每个层只与上面的层和下面的层进行通信。每一层都使用下面的层来执行其功能。他们通过预定义的、固定的接口进行通信。较低的层提供功能和服务，以支持较高的层的功能和服务。

- 如CLI作为Presentation Layer仅和Business Layer进行通信，每个层内定义了许多的接口供上层访问，这些类或模块的行为就像它们都在同一个层中。在CLI需要进行操作的时候，仅通过BIZ的接口函数进行操作即可，而不需要直接访问DB。

- 层不需要明确的表示。不需要创建层类或类似的东西。只要确保创建的对象只与正确的层中的对象对话以进行相应 的操作。换句话说，也就是其实也可以将各层的实现表示在一个文件之内。只需要保证实现的层仅需求下层提供的接口即可。每个层只关注该层的局部附近的实现，而不需要考虑整体。整体应该是各个局部的和。

