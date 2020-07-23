#!/usr/bin/env bash
set -ex

#Install Pivnet
sudo apt-get update
wget -O pivnet github.com/pivotal-cf/pivnet-cli/releases/download/v0.0.55/pivnet-linux-amd64-0.0.55 && chmod +x pivnet && sudo mv pivnet /usr/local/bin
pivnet login --api-token=$1

#Install PKS CLI
pivnet download-product-files --product-slug='pivotal-container-service' --release-version='1.7.0' --product-file-id=646536
sudo mv pks-linux-amd64-1.7.0-build.483 pks
chmod +x pks
sudo mv pks /usr/local/bin/

#Install Kubectl
pivnet download-product-files --product-slug='pivotal-container-service' --release-version='1.7.0' --product-file-id=633728
sudo mv  kubectl-linux-amd64-1.16.7 kubectl
sudo mv kubectl /usr/local/bin/