## bootRun での起動

- 以下コマンド実行  
```
./gradlew bootRun
```

- 以下にアクセス  
http://localhost:5000/swagger-ui/


## Docker での起動方法
- jarファイルを作成し、dockerディレクトリに配置 
```
./gradlew bootJar
```

- Dockerfileのあるディレクトリに移動  
```
cd docker
```

- 次のコマンド実行  
```
docker build -t word-test-image .  
docker run -p 5000:5000 word-test-image
```

- 以下にアクセス  
http://localhost:5000/swagger-ui/
