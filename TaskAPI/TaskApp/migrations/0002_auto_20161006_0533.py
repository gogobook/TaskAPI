# -*- coding: utf-8 -*-
# Generated by Django 1.10.2 on 2016-10-06 05:33
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('TaskApp', '0001_initial'),
    ]

    operations = [
        migrations.RenameField(
            model_name='task',
            old_name='data_created',
            new_name='date_created',
        ),
    ]
