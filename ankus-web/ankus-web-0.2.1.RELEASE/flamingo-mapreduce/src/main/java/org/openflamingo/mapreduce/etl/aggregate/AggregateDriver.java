package org.openflamingo.mapreduce.etl.aggregate;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.ToolRunner;
import org.openflamingo.mapreduce.core.AbstractJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static org.openflamingo.mapreduce.core.Constants.JOB_FAIL;
import static org.openflamingo.mapreduce.core.Constants.JOB_SUCCESS;

/**
 * 하나 이상의 입력 파일을 받아서 합치는 Aggregation ETL Driver.
 * 이 MapReduce ETL은 다음의 파라미터를 가진다.
 * <ul>
 *     <li><tt>lineCountPerFile (c)</tt> - 파일당 라인수 측정 여부 (선택) (기본값 false)</li>
 * </ul>
 *
 * @author Edward KIM
 * @author Seo Ji Hye
 * @since 0.1
 */
public class AggregateDriver extends AbstractJob {

	/**
	 * SLF4J API
	 */
	private static final Logger logger = LoggerFactory.getLogger(AggregateDriver.class);

	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new AggregateDriver(), args);
		System.exit(res);
	}

	@Override
	public int run(String[] args) throws Exception {
		addInputOption();
		addOutputOption();

		addOption("lineCountPerFile", "lc", "파일당 라인수 측정(true | false)", "false");

		Map<String, String> parsedArgs = parseArguments(args);
		if (parsedArgs == null) {
			return JOB_FAIL;
		}

		Job job = prepareJob(getInputPath(), getOutputPath(),
			TextInputFormat.class,
			AggregateMapper.class,
			NullWritable.class,
			Text.class,
			TextOutputFormat.class);

        System.out.println(this.getTempPath());

		job.getConfiguration().set("lineCountPerFile", parsedArgs.get("--lineCountPerFile"));

		return job.waitForCompletion(true) ? JOB_SUCCESS : JOB_FAIL;
	}

}