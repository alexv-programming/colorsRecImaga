package telran.colors.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Colors {
	List<AllColors> background_colors;
	List<AllColors> foreground_colors;
	List<AllColors> image_colors;
}
