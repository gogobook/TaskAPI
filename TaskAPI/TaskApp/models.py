from django.db import models

# Create your models here.
class Task(models.Model):
    task_name=models.CharField(max_length=20)
    task_desc=models.TextField(max_length=200)
    completed=models.BooleanField(default=False)
    date_created=models.DateTimeField(auto_now=True)
    image=models.ImageField(upload_to='Images/', default='Images/None/No-img.gif')

    def __str__(self):
        return "%s" % self.task_name
