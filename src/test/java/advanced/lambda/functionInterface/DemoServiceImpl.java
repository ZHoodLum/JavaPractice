package advanced.lambda.functionInterface;

import lombok.extern.slf4j.Slf4j;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/4 8:21
 * @Description:
 */

@Slf4j
public class DemoServiceImpl {

    public static void main(String[] args) {
        CreateInterfaceService createInterfaceService = new CreateInterfaceService() {
            @Override
            public void active() {
                log.info("你好，我是lambda表达式");
            }
        };
        runMethod(createInterfaceService);

        System.out.println("我是分割綫！！！！！");


        CreateInterfaceService createInterfaceService2 = () -> {
            System.out.println("你好，我是lambda表达式");
        };
        runMethod(createInterfaceService2);


    }

    //調用靜態方法
    public static void runMethod(CreateInterfaceService createInterfaceService) {
        createInterfaceService.active();
    }
}
