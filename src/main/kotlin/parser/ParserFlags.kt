package computor.parser

import computor.globalFlags

fun parserFlags(args: Array<String>) {
	args.forEach {
		when(it) {
			"-r" -> globalFlags.add(Flags.REDUCED_FORM)
			"-f" -> globalFlags.add(Flags.FRACTION)
			"-u" -> globalFlags.add(Flags.USAGE)
		}
	}
}