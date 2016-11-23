. activate dj110
ifconfig
docker start cd7242
docker ps 

export $(cat .env)

python manage.py gunserver 0.0.0.0:8000