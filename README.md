# wordstream-flink

Streaming filter on Flink for netcat on Windows. You need to run netcat "nc" on Windows using the following commnad:

```cmd
nc64.exe -L -p 9999
```

In Linux/Mac OS, this command will be:

```bash
nc -l 9999
```

The code can be run directly from within the Intellij IDEA IDE. 

Flink examples:
* FilterSettings: Basic streaming by filtering `double` input only. Other types of input will be ignored.
* WaterMarkEventSettings: Creating a sum 10-second window every 5 seconds.
