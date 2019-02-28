package com.ortona.stefano.hashcode_2019.io;

import com.ortona.stefano.hashcode_2019.UtilsFile;
import com.ortona.stefano.hashcode_2019.model.ProblemContainer;

public class ProblemReader {
	public ProblemContainer readProblem(String fileLocation) {
		UtilsFile fr = new UtilsFile(fileLocation);

		return fr.getProblemContainer();
	}

}
