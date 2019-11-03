package is;

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
}
