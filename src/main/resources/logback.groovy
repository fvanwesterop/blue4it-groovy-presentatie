
statusListener(OnConsoleStatusListener)

appender('stdout', ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = '[min-gorm] %-4relative %-5level %logger{35} - %msg %n'
  }
}

def appenders = [
	'stdout'
]

logger('mini-gorm', INFO);

root(INFO, appenders);