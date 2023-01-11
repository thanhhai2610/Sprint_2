import {ImgGuide} from "./img_guide";

export interface Guide {
  id?: string;
  title?: string;
  content?: string;
  deleteStatus?: boolean;
  images?: ImgGuide;
}
