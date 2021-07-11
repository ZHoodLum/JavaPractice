package advanced.lambda.entity;

import lombok.Data;

import java.util.Objects;

/**
 * @author：ZDY
 * @Date：Created on 2021/7/5 8:19
 * @Description:
 */

@Data
public class MessageEntity {
    String sex;
    String name;
    Double money;

    public MessageEntity(String sex, String name, Double money) {
        this.sex = sex;
        this.name = name;
        this.money = money;
    }

    public MessageEntity() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return sex.equals(that.sex) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sex, name);
    }
}
