#!/bin/bash
docker run -e POSTGRES_HOST=postgres -e POSTGRES_DB=statistics -e POSTGRES_USER=sarah -e POSTGRES_PASSWORD=connor prodrigestivill/postgres-backup-local /backup.sh