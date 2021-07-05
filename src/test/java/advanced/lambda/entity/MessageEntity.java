package advanced.lambda.entity;

import lombok.Data;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/5 8:19
 * @Description:
 */

@Data
public class MessageEntity {
    String sex;
    String name;

    public MessageEntity(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }

    public MessageEntity() {

    }
}
