#!/usr/bin/env bash
set -ex

kubectl delete -f deployment/pages-namespace.yaml
kubectl apply -f deployment/pages-namespace.yaml
kubectl apply -f deployment/pages-config.yaml
kubectl apply -f deployment/pages-service.yaml
kubectl apply -f deployment/pages-deployment.yaml