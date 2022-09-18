package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_72
   extends TilingType
{
   public TilingTypeNC6_72(){
      super( "NC6-72", 6, SymmetryType.p2 );

      paramMin = new int[]{};
      paramMax = new int[]{};
      paramDef = new int[]{};
      paramName = new String[]{};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,5, 0,2,3, 0},
            {1, 4,3, 1,3,4, 0},
            {0, 2,3, 2,0,5, 0},
      };
      info = "a=b=c=d=e=f\nA=120\nB=120\nC=60\nD=240\nE=60\n(F=120)";
   }
   
   public void recalcBase(double[] paramValues) {
      double ln = .5;

      double w = ln/2;
      double h = w * Math.sqrt(3);

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1,2*w,  0);
      baseTile.setPoint(2,3*w,  h);
      baseTile.setPoint(3,  w,  h);
      baseTile.setPoint(4,  0,2*h);
      baseTile.setPoint(5, -w,  h);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(1)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(1)-tiles[0].getY(0);
      offsets[2] = tiles[3].getX(1)-tiles[0].getX(0);
      offsets[3] = tiles[3].getY(1)-tiles[0].getY(0);
   }
}