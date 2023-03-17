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
public class Blog {
	private int blogseq;
	private String blogid;
	private String title;
	private String blogtext;
	private String regdate;
	private int likecnt;
}
