package david.maisuradze.weather;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/weatherbot")
public class WeatherBotController {
    @OnOpen
    public void handleOpen() {
        System.out.println("Connected ...");
    }

    @OnMessage
    public String handleMessage(String message) {
        System.out.println("MSG From Client : " + message);
        String replayMessage = "";
        try {
            if (message.equals("all")) {
                replayMessage = Services.get("http://localhost:8080/david_maisuradze_davaleba_1_war_exploded/api/weather/");
            } else {
                replayMessage = Services.get("http://localhost:8080/david_maisuradze_davaleba_1_war_exploded/api/weather/" + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("MSG From Server : " + replayMessage);
        return replayMessage;
    }

    @OnClose
    public void handleClose() {
        System.out.println("End Connection ...");
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }

}