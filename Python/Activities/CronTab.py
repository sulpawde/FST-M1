import os
import sys
sys.path.append(os.path.join(os.environ['USERPROFILE'], 'AppData', 'Local', 'Programs', 'Python', 'Python312', 'Lib', 'site-packages'))


#import sys
#sys.path.append("C:/Users/SULBHAPAWDE/AppData/Local/Programs/Python/Python312/Lib/site-packages/")
import CronTab
from crontab import CronTab
cron = CronTab(user='root')
job = cron.new(command='echo hello_world')
job.minute.every(1)
cron.write()