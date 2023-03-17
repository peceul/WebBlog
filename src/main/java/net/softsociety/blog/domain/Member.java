package net.softsociety.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String blogid;
	private String blogpwd;
	private String bloggername;
	private int photo;
}
