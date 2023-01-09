import {ImgWatch} from '../product/img_watch';

export interface WatchDto {
  id?: number;
  name?: string;
  faceDiameter?: string;
  waterproof?: string;
  faceMaterial?: string;
  strapSize?: string;
  wireMaterial?: string;
  shellMaterial?: string;
  designs?: string;
  warranty?: string;
  registerDay?: string;
  description?: string;
  price?: number;
  quantity?: number;
  avatar?: string;
  category?: number;
  brand?: number;
  deleteStatus?: boolean;
  imgUrlProducts?: ImgWatch;
}

