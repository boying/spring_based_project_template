rm src/main/resources/mybatis-mapper/book/mapper/*.xml
rm src/main/resources/mybatis-mapper/user/mapper/*.xml

mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate