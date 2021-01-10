<template>
  <div>
    <b-carousel
      id="carousel-id"
      img-width="500"
      img-center
      :interval="3000"
      indicators
      background="#fffff"
      style="text-shadow: 1px 1px 2px #333"
    >
      <b-carousel-slide>
        <template #img>
          <div class="text-center">
            <img class="img-fluid" width="400" src="/content/images/salsa/pilares.png" alt="image slot" />
          </div>
        </template>
      </b-carousel-slide>
      <b-carousel-slide>
        <template #img>
          <div class="text-center">
            <img class="img-fluid" width="400" src="/content/images/salsa/plataformas.png" alt="image slot" />
          </div>
        </template>
      </b-carousel-slide>
      <b-carousel-slide>
        <template #img>
          <div class="text-center">
            <img class="img-fluid" width="400" src="/content/images/salsa/practicas.png" alt="image slot" />
          </div>
        </template>
      </b-carousel-slide>
      <b-carousel-slide>
        <template #img>
          <div class="text-center">
            <img class="img-fluid" width="400" src="/content/images/salsa/direcciones.png" alt="image slot" />
          </div>
        </template>
      </b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script lang="ts" src="./info.component.ts">
</script>
