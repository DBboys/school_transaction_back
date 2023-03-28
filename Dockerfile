# 基础镜像
FROM openjdk:8

# 添加jar 包
ADD ./target/shizuku_anime_server_test.jar /home/shizuku_anime/
 
# 执行命令
CMD exec java -jar -Dfile.encoding=UTF-8 -Duser.timezone=GMT+8 /home/shizuku_anime/shizuku_anime_server_test.jar
