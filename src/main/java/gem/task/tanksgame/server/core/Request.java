package gem.task.tanksgame.server.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.Socket;

@Getter
@Setter
@AllArgsConstructor
public class Request {
    private Socket requestSocket;
}
