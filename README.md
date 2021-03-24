# CyberSource v2
a small library to help with [Cybersource v2](https://www.cybersource.com/en-us.html) encryption

# Usage
```java
import me.brennan.cybersource.CyberSourcev2;
import me.brennan.cybersource.models.Card;
import me.brennan.cybersource.models.CardTypes;

public class Test {

    public static void main(String[] args) throws Exception {
        final String KEY_ID = "{KEY_ID}";
        final CyberSourcev2 cyberSourcev2 = new CyberSourcev2(KEY_ID);

        final Card card = new Card("4242424242424242", "666", "10", "2021", CardTypes.VISA);

        System.out.println(cyberSourcev2.encrypt(card));
    }

}
```
