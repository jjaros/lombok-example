package cz.jjaros.playing.lombok.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DestroyableObject {

    @Getter
    private boolean destroyed = false;

    public void destroy() {
        destroyed = true;
    }
}
