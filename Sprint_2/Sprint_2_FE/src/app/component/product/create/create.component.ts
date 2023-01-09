import {Component, OnInit} from "@angular/core";
import {Watch} from "../../../model/product/watch";
import {WatchDto} from "../../../model/dto/watch_dto";
import {Category} from "../../../model/product/category";
import {Brand} from "../../../model/product/brand";
import {FormBuilder, FormGroup} from "@angular/forms";
import {User} from "../../../model/users/user";
import {WatchServiceService} from "../../../service/watch-service.service";
import {CategoryServiceService} from "../../../service/category-service.service";
import {AngularFireStorage} from "@angular/fire/storage";
import {UserServiceService} from "../../../service/user-service.service";
import {ImgWatchServiceService} from "../../../service/img-watch-service.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {ImgWatch} from "../../../model/product/img_watch";
import {ImgWatchDto} from "../../../model/dto/img_watch_dto";
import {finalize} from "rxjs/operators";


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  watch: Watch;
  watchDto: WatchDto;
  categoryList: Category[] = [];
  brandList: Brand[] = [];
  formCreateProduct: FormGroup;
  userFind: User;
  userId: number;
  selectedImages: any[] = [];
  imgWatch: any[] = [];
  imgAvatar: any[] = [];
  error: any;
  selectedFile: any[] = [];
  messageCreate = '';
  messageImage = '';
  currentUser: User;


  constructor(
    private formBuilder: FormBuilder,
    private watchService: WatchServiceService,
    private categoryService: CategoryServiceService,
    private storage: AngularFireStorage,
    private imageProductService: ImgWatchServiceService,
    private toast: ToastrService,
    // private _tokenService: TokenService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.categoryService.getListCategory().subscribe((data) => {
      console.log('category', data);
      this.categoryList = data;
    });

    this.watchService.getListBrand().subscribe((data) => {
      console.log('category', data);
      this.brandList = data;
    });
    this.formCreateProduct = this.formBuilder.group(
      {
        id: [''],
        name: [''],
        faceDiameter: [''],
        waterproof: [''],
        faceMaterial: [''],
        strapSize: [''],
        wireMaterial: [''],
        shellMaterial: [''],
        designs: [''],
        warranty: [''],
        registerDay: [''],
        description: [''],
        price: [''],
        quantity: [''],
        avatar: [''],
        category: [''],
        brand: [''],
        deleteStatus: [''],
        imgUrlProducts: [''],
        productOrderDetails: [''],
      },
      // {validators: [checkStartTime, checkEndTime]}
    );
  }

  addNewProduct() {
    this.watchDto = this.formCreateProduct.value;
    console.log(this.watchDto);
    this.watchService.addProduct(this.watchDto).subscribe(
      (data) => {
        if (this.imgWatch.length !== 0 && this.imgAvatar.length !== 0) {
          for (let i = 0; i < this.imgWatch.length; i++) {
            const image: ImgWatchDto = {
              url: this.imgWatch[i],
              watch: data.id,
            };
            this.imageProductService.create(image).subscribe(() => {
            });
          }
        }
        this.router.navigateByUrl('');
        this.toast.success(
          'Bạn đã thêm thành công món ăn',
          '',
          {
            timeOut: 3000,
            progressBar: true,
          }
        );
      },
      (error) => {
        this.toast.error(
          'Yêu cầu thêm món ăn của bạn chưa thành công, vui lòng kiểm tra'
        );
      }
    );
  }

  showPreviewImgWatch(event: any) {
    this.messageImage = 'Đang tải ảnh vui lòng đợi một lát';
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
      this.selectedFile = event.target.files;
    } else {
      this.selectedFile = [];
    }
    if (this.selectedFile.length !== 0) {
      if (this.selectedFile.length > 5) {
        this.messageImage = 'Vui lòng không chọn quá 5 ảnh';
        this.imgWatch = [];
        this.selectedFile = [];
        this.formCreateProduct.controls['imgUrlProducts'].setValue([]);
      } else {
        for (let i = 0; i < this.selectedFile.length; i++) {
          if (this.selectedFile[i].size > 1000000) {
            console.log(this.selectedFile[i]);
            this.messageImage =
              "Dung lượng ảnh " +
              this.selectedFile[i].name +
              " đã vượt quá 10KB";
            this.imgWatch = [];
            this.selectedFile = [];
            this.formCreateProduct.controls["imgUrlProducts"].setValue([]);
            return;
          }
        }
        for (let i = 0; i < this.selectedFile.length; i++) {
          const selectedImage = this.selectedFile[i];
          const n = Date.now();
          const filePath = `RoomsImages/${n}`;
          const fileRef = this.storage.ref(filePath);
          this.storage
            .upload(filePath, selectedImage)
            .snapshotChanges()
            .pipe(
              finalize(() => {
                fileRef.getDownloadURL().subscribe((url) => {
                  this.messageImage = '';
                  this.imgWatch.push(url);
                  console.log(url);
                });
              })
            )
            .subscribe(() => {});
        }
      }
    }
  }
  showPreviewAvatar(event: any) {
    this.messageImage = 'Đang tải ảnh vui lòng đợi một lát';
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.readAsDataURL(event.target.files[0]);
      this.selectedFile = event.target.files;
    } else {
      this.selectedFile = [];
    }
    if (this.selectedFile.length !== 0) {
      if (this.selectedFile.length > 1) {
        this.messageImage = 'Vui lòng không chọn quá 1 ảnh';
        this.imgAvatar = [];
        this.selectedFile = [];
        this.formCreateProduct.controls["avatar"].setValue([]);
      }
    }
  }
  deleteImageNew(index) {
    this.imgWatch.splice(index, 1);
    this.imgAvatar.splice(index, 1);
    this.toast.error("Bạn đã xóa 1 ảnh!");
  }
  resetFindUserById(testNum) {
    testNum.removeAttribute("disabled");
  }
  resetForm(file) {
    this.ngOnInit();
    this.imgWatch = [];
    this.imgAvatar = [];
    file.value = '';
  }
}
