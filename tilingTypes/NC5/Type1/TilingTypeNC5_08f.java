package tilingTypes.NC5.Type1;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC5_08f
   extends TilingType
{
   public TilingTypeNC5_08f(){
      super( "NC5-8f: sawtooth", 5, SymmetryType.p2 );

      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 50, 50};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,4, 0,0,4, 1},
            {1, 1,0, 1,0,1, 1},
            {0, 0,4, 2,0,4, 0},
      };
      info = "b=c=d\ne=3b\nB+C=360\n2A=C\n(A+D+E=180)";
   }

   public void recalcBase(double[] paramValues) {
      double lnb = .6*paramValues[0]/100.;   // base length
      double lnh = (.6 - lnb)*3/4; // teeth height

      double x1 = lnb;
      double y1 = lnh;
      double x2 = 2*lnb;
      double y2 = 0;
      double x3 = 3*lnb;
      double y3 = lnh;
      double x4 = 0;
      double y4 = 4*lnh;

      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, x1, y1);
      baseTile.setPoint(2, x2, y2);
      baseTile.setPoint(3, x3, y3);
      baseTile.setPoint(4, x4, y4);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[0].getX(4);
      offsets[1] = tiles[0].getY(3)-tiles[0].getY(4);
      offsets[2] = tiles[3].getX(3)-tiles[0].getX(4);
      offsets[3] = tiles[3].getY(3)-tiles[0].getY(4);
      double os = paramValues[1]/50.-1;
      if(os>=0){
         offsets[0] += os * offsets[2];
         offsets[1] += os * offsets[3];
      }else{
         offsets[2] += os * offsets[0];
         offsets[3] += os * offsets[1];
      }
   }
}
