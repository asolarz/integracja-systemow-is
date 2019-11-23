package core.is;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Screen {

    private String displaySize;
    private String resolution;
    private String screenType;

    public com.example.Screen toScreen() {
        com.example.Screen screen = new com.example.Screen();
        screen.setDisplaySize(displaySize);
        screen.setResolution(resolution);
        screen.setScreenType(screenType);
        return screen;

    }
}
