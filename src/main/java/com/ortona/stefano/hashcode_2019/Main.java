package com.ortona.stefano.hashcode_2019;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ortona.stefano.hashcode_2019.io.ProblemReader;
import com.ortona.stefano.hashcode_2019.io.ProblemWriter;
import com.ortona.stefano.hashcode_2019.logic.ProblemSolver;
import com.ortona.stefano.hashcode_2019.model.SolutionContainer;

public class Main {

	static Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		final String inputFile1 = "a_example.txt";
		final String inputFile2 = "b_lovely_landscapes.txt";
		final String inputFile3 = "";
		final String inputFile4 = "";

		final List<String> inputFiles = new LinkedList<>();
		// inputFiles.add(inputFile1);
		inputFiles.add(inputFile2);
		// inputFiles.add(inputFile3);
		// inputFiles.add(inputFile4);

		final ProblemReader reader = new ProblemReader();
		final ProblemSolver solver = new ProblemSolver();

		final Map<String, Double> file2score = new HashMap<>();
		for (final String oneFile : inputFiles) {
			LOG.info("Processing file: '{}'", oneFile);
			final SolutionContainer solution = solver.process(reader.readProblem(oneFile));
			final ProblemWriter writer = new ProblemWriter();
			final double curScore = solution.score;
			file2score.put(oneFile, curScore);
			writer.writeProblem(oneFile + "_output", solution);
			LOG.info("Finished processing file '{}' with score '{}'", oneFile, curScore);
		}
		LOG.info("Individual scores: {}", file2score);
		LOG.info("Tot score: {}", file2score.values().stream().mapToDouble(Double::doubleValue).sum());
	}

}
