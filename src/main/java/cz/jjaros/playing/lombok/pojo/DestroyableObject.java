package cz.jjaros.playing.lombok.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author <a href="mailto:jarosjan@yahoo.com">Jan Jaros</a>
 */
@NoArgsConstructor(staticName = "create")
public class DestroyableObject {

    @Getter
    private boolean destroyed = false;

    public void destroy() {
        destroyed = true;
    }
}
