package telran.colors.dto;

import java.util.Iterator;

import lombok.Getter;
import lombok.ToString;

@Getter
public class AllColors {
	String closest_palette_color;
	String closest_palette_color_parent;
	double percent;
	
	@Override
	public String toString() {
		int ftab = 4  - (closest_palette_color.length()/4);
		int stab = closest_palette_color_parent.length();
		StringBuilder fString = new StringBuilder("");
		
		for (int i = 0; i < ftab; i++) {
			fString.append("\t");
		}
		return closest_palette_color + 
				fString 
				+ closest_palette_color_parent + 
				"\t" + percent ;
	}
	
	
}
