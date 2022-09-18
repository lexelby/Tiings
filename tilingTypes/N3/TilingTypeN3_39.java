package tilingTypes.N3;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeN3_39
   extends TilingType
{
   public TilingTypeN3_39(){
      super( "N3-39",3, SymmetryType.p2 );
      // params are angle/distance of the other two points relative to first one
      paramMin = new int[]{  0,  0};
      paramMax = new int[]{100,100};
      paramDef = new int[]{ 40, 50};
      paramName = new String[]{ "Aspect", "Offset" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,2, 0,0,2, 1},
            {2, 1,0, 1,0,1, 1},
            {3, 2,0, 2,0,2, 1},

            {0, 0,1, 3,0,1, 0},
            {1, 0,2, 4,0,2, 1},
            {2, 1,0, 5,0,1, 1},
            {3, 2,0, 6,0,2, 1},
      };
      info = "A=90\n(B+C=90)";
   }

   public void recalcBase(double[] paramValues) {
      double ln2 = 2*getParam(paramValues,0)/100.;
      double ln1 = 2-ln2;
      baseTile.setPoint(0,   0, 0);
      baseTile.setPoint(1, ln1, 0);
      baseTile.setPoint(2,   0, ln2);
   }
   public void recalcOffsets(double[] paramValues) {
      double os = 2*(paramValues[1] / 100.)-1;
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(2);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(2);
      offsets[2] = tiles[0].getX(1)-tiles[4].getX(2);
      offsets[3] = tiles[0].getY(1)-tiles[4].getY(2);
      if( os>=0 ){
         offsets[0] += os * offsets[2];
         offsets[1] += os * offsets[3];
      }else{
         offsets[2] += os * offsets[0];
         offsets[3] += os * offsets[1];
      }
   }
}
