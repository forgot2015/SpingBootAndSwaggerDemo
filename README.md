# 一个SpringBoot结合Swagger写接口文档的例子

## Swagger接入

在原有的SpringBoot中接入Swagger

### 第一步。
在pom.xml中添加maven依赖
````
 <!--swagger库-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.8.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.8.0</version>
````
### 第二步。
创建Swagger2配置类 , 代码如下
````
@Configuration
public class Swagger2 {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格，http://blog.csdn.net/saytime")
                .termsOfServiceUrl("http://blog.csdn.net/saytime")
                .version("1.0")
                .build();
    }
}
````

### 第三步。
在你的Application类顶部添加注解
`@EnableSwagger2`

### 第四步。
在Controller类中编写接口注解文档
比如：
````
@Api(value="/test", tags="Swagger测试接口模块")
@RestController
@RequestMapping("/api")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @ApiOperation(value="根据Id查询用户信息", notes = "根据Id查询用户信息,这里是详细说明")
    @ApiImplicitParam(name="id", value="用户唯一id", required = true, dataType = "Long")
    @RequestMapping(value="/user",params = "id",method = RequestMethod.GET)
    public User getUserById(@RequestParam Long id){
        return userService.findById(id);
    }

    @ApiOperation(value="根据Id添加用户信息", notes = "根据Id添加用户信息,这里是详细说明")
    @ApiImplicitParam(name="id", value="用户唯一id", required = true, dataType = "Long")
    @RequestMapping(value="/user",params = "id",method = RequestMethod.POST)
    public User addUser(@RequestParam Long id){
        return userService.addUser(id);
    }
}
````
最后，访问http://localhost:8080/swagger-ui.html 即可看到你的杰作

具体demo见github仓库 
https://github.com/forgot2015/SpingBootAndSwaggerDemo

## 更多内容阅读
https://www.jianshu.com/p/b0b19368e4a8
https://blog.csdn.net/xupeng874395012/article/details/68946676


